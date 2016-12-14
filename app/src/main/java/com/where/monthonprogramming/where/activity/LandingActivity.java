package com.where.monthonprogramming.where.activity;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.where.monthonprogramming.where.R;
import com.where.monthonprogramming.where.dao.BooksDao;
import com.where.monthonprogramming.where.dao.NfcsDao;
import com.where.monthonprogramming.where.fragment.LandingFragment;
import com.where.monthonprogramming.where.fragment.NfctabFragment;
import com.where.monthonprogramming.where.fragment.SearchFragment;
import com.where.monthonprogramming.where.manager.HttpManager;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;


public class LandingActivity extends AppCompatActivity
        implements LandingFragment.Fragmentlistener{

    Toolbar toolbar;

    public static final String MIME_TEXT_PLAIN = "text/plain";
    public static final String TAG = "NfcDemo";
    private NfcAdapter mNfcAdapter;

    //NFC Value
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        if (savedInstanceState == null){
            //First create
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, new LandingFragment())
                    .commit();
        }
        //We Handle in method initInstances.
        initInstances();
    }

    private void initInstances() {
        //Create View
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

    }


    @Override
    public void onButtonClickNFC(ImageButton btnNfc) {
        //NFC Button
        //TODO Handle
        //replace fragment by NfctabFrahment.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainer, new NfctabFragment())
                .addToBackStack(null)
                .commit();

        if (mNfcAdapter == null) {
            // Stop here, we definitely need NFC
            Toast.makeText(this, "This device doesn't support NFC.",
                    Toast.LENGTH_LONG)
                    .show();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentContainer, new LandingFragment())
                    .commit();
            return;
        }

        if (!mNfcAdapter.isEnabled()) {
            //NFC Status
            Toast.makeText(this,"Nfc is Disable",
                    Toast.LENGTH_SHORT)
                    .show();
        } else {
            //NFC Status
            Toast.makeText(this,"Nfc is Enable",
                    Toast.LENGTH_SHORT)
                    .show();
        }

        //NFC execute (When we tap nfc tag)
        handleIntent(getIntent());

    }

    @Override
    public void onButtonClickSearch(ImageButton btnSearch) {
        //Search Button
        Intent intent = new Intent(LandingActivity.this, SearchActivity.class);
        startActivity(intent);

    }

    @Override
    public void onButtonClickMap(ImageButton btnMap) {
        //Map button
        Intent intent = new Intent(LandingActivity.this, MapActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mNfcAdapter != null) {
            setupForegroundDispatch(this, mNfcAdapter);
        }
    }

    @Override
    protected void onPause() {
        if(mNfcAdapter != null) {
            stopForegroundDispatch(this, mNfcAdapter);
        }
        super.onPause();
    }

    public static void setupForegroundDispatch(final LandingActivity activity,
                                               NfcAdapter adapter) {
        final Intent intent = new Intent(activity.getApplicationContext(),
                activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        final PendingIntent pendingIntent = PendingIntent
                .getActivity(activity
                .getApplicationContext(), 0, intent, 0);

        IntentFilter[] filters = new IntentFilter[1];
        String[][] techList = new String[][]{};

        // Notice that this is the same filter as in our manifest.
        filters[0] = new IntentFilter();
        filters[0].addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filters[0].addCategory(Intent.CATEGORY_DEFAULT);
        try {
            filters[0].addDataType(MIME_TEXT_PLAIN);
        } catch (IntentFilter.MalformedMimeTypeException e) {
            throw new RuntimeException("Check your mime type.");
        }
        adapter.enableForegroundDispatch(activity,
                pendingIntent,
                filters,
                techList);
    }
    public static void stopForegroundDispatch(final LandingActivity activity, NfcAdapter adapter) {
        adapter.disableForegroundDispatch(activity);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {

            String type = intent.getType();
            if (MIME_TEXT_PLAIN.equals(type)) {

                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                new NdefReaderTask().execute(tag);
            } else {
                Log.d(TAG, "Wrong mime type: " + type);
            }
        } else if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)) {

            // In case we would still use the Tech Discovered Intent
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String[] techList = tag.getTechList();
            String searchedTech = Ndef.class.getName();

            for (String tech : techList) {
                if (searchedTech.equals(tech)) {
                    new NdefReaderTask().execute(tag);
                    break;
                }
            }
        }
    }

    private class NdefReaderTask extends AsyncTask<Tag, Void, String> {

        @Override
        protected String doInBackground(Tag... params) {
            Tag tag = params[0];

            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                // NDEF is not supported by this Tag.
                return null;
            }

            NdefMessage ndefMessage = ndef.getCachedNdefMessage();

            NdefRecord[] records = ndefMessage.getRecords();
            for (NdefRecord ndefRecord : records) {
                if (ndefRecord.getTnf() == NdefRecord
                        .TNF_WELL_KNOWN && Arrays
                        .equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                    try {
                        return readText(ndefRecord);
                    } catch (UnsupportedEncodingException e) {
                        Log.e(TAG, "Unsupported Encoding", e);
                    }
                }
            }

            return null;
        }

        private String readText(NdefRecord record) throws UnsupportedEncodingException {

            byte[] payload = record.getPayload();

            // Get the Text Encoding
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";

            // Get the Language Code
            int languageCodeLength = payload[0] & 0063;

            // String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            // e.g. "en"

            // Get the Text
            return new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
        }

        @Override
        protected void onPostExecute(final String result) {
            //Get nfc value
            if (result != null) {
                //set nfc Value
                setResult(result);
                //Call service NFCsService
                Call<List<NfcsDao>> call = HttpManager.getInstance()
                        .getService()
                        .all2();

                call.enqueue(new Callback<List<NfcsDao>>() {
                    @Override
                    public void onResponse(Call<List<NfcsDao>> call, Response<List<NfcsDao>> response) {
                        String resultNfc = getResult();

                        for(int i=0;i<response.body().size();i++){
                            //Find match NfcId

                            if(response.body().get(i).getNfcId().equalsIgnoreCase(resultNfc)){
                                //Check match between NfcId on service and nfc value on tag.
                                String resViewId =  response.body().get(i).getViewId();
                                String nfcFloor = response.body().get(i).getFloor();

                                if(resViewId!=null && nfcFloor!=null) {
                                    //send floorId and viewId from nfcId on service to SearchActivity
                                    Intent intent = new Intent(LandingActivity.this, SearchActivity.class);
                                    intent.putExtra("result", resViewId);
                                    intent.putExtra("nfcFloor",nfcFloor);
                                    startActivity(intent);
                                    break;
                                }
                            }
                            else if (i==(response.body().size()-1)){
                                //not found nfc on service
                                Toast.makeText(LandingActivity.this,"NFC WRONG!!",
                                        Toast.LENGTH_SHORT)
                                        .show();
                                break;
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<NfcsDao>> call, Throwable t) {
                        //tell me failure messages
                        t.printStackTrace();
                        Log.d("Fail",t.getMessage());
                    }
                });


            }else {Toast.makeText(LandingActivity.this,"NFC WRONG!!",Toast.LENGTH_SHORT).show();}
        }
    }
}


