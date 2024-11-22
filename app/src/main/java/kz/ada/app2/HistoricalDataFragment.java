package kz.ada.app2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.FutureCallback;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import api.RetrofitInstance;

public class HistoricalDataFragment extends Fragment {

    public HistoricalDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_historical_data, container, false);

        // Find the TextView where we will display the generated content
        TextView contentTextView = rootView.findViewById(R.id.textViewContent);

        // Set up the Gemini model
        GenerativeModel gm = new GenerativeModel(
                "gemini-1.5-flash",
                RetrofitInstance.INSTANCE.getApi_key() // API key from BuildConfig
        );

        GenerativeModelFutures model = GenerativeModelFutures.from(gm);

        // Define the content to be generated
        Content content = new Content.Builder()
                .addText("Write a story about a magic backpack.")
                .build();

        // Use a single-threaded executor for the asynchronous call
        Executor executor = Executors.newSingleThreadExecutor();

        // Generate the content asynchronously
        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);

        // Add a callback to handle the response
        Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
            @Override
            public void onSuccess(GenerateContentResponse result) {
                // On success, update the TextView with the generated content
                String resultText = result.getText();
                contentTextView.setText(resultText);
            }

            @Override
            public void onFailure(Throwable t) {
                // On failure, log the error and display a message in the TextView
                t.printStackTrace();
                contentTextView.setText("Error generating content.");
            }
        }, executor);


        return rootView;
    }
}





