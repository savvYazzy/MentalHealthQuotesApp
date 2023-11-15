package com.example.mentalhealthquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Quotes extends AppCompatActivity {

    private TextView quoteTxt, writerName;
    private  final List<QuotesList> quotesLists = new ArrayList<>();

    private int currentQuotePositon = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        final TextView categoryName = findViewById(R.id.categoryName);
        quoteTxt = findViewById(R.id.quouteTxt);
        writerName = findViewById(R.id.writerName);

        final Button prevBtn = findViewById(R.id.prevBtn);
        final Button nextBtn = findViewById(R.id.nextBtn);
        final ImageView copyBtn = findViewById(R.id.copyBtn);


        // get category name from CategoriesAdapter class
        final String getName = getIntent().getStringExtra("name");

        categoryName.setText(getName);

        if (getName.equals("ADHD")) {
            quotesLists.addAll(QuotesData.getADHDQuotes());
        } else if (getName.equals("Anxiety")) {
            quotesLists.addAll(QuotesData.getAnxietyQuotes());
        } else if (getName.equals("Depression")) {
            quotesLists.addAll(QuotesData.getDepressionQuotes());
        } else if (getName.equals("Substance Abuse")) {
            quotesLists.addAll(QuotesData.getSubstanceQuotes());
        } else if (getName.equals("Eating Disorder")) {
            quotesLists.addAll(QuotesData.getEatingQuotes());
        } else if (getName.equals("PTSD")) {
            quotesLists.addAll(QuotesData.getPersonalityQuotes());
        } else if (getName.equals("Personality Disorders")) {
            quotesLists.addAll(QuotesData.getPersonalityQuotes());
        } else if (getName.equals("Dissociation")) {
            quotesLists.addAll(QuotesData.getDissociationQuotes());
        } else if (getName.equals("OCD")) {
            quotesLists.addAll(QuotesData.getOCDquotes());
        } else if (getName.equals("Paranoia")) {
            quotesLists.addAll(QuotesData.getParanoiaQuotes());
        } else if (getName.equals("Schizophrenia")) {
            quotesLists.addAll(QuotesData.getSchizophreniaQuotes());
        } else if (getName.equals("Psychosis")) {
            quotesLists.addAll(QuotesData.getPsychosisQuotes());
        }


        setQuoteTxtToTextView();

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentQuotePositon--;
                if(currentQuotePositon < 0){
                    currentQuotePositon = quotesLists.size() - 1;
                }

                setQuoteTxtToTextView();

            }
        });


        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("quote", quotesLists.get(currentQuotePositon).getQuote()+"\nby "+quotesLists.get(currentQuotePositon).getWriter());
                clipboardManager.setPrimaryClip(clipData);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentQuotePositon++;

                if(currentQuotePositon >= quotesLists.size()){
                    currentQuotePositon = 0;
                }

                setQuoteTxtToTextView();
            }
        });

    }

    private void setQuoteTxtToTextView() {

        quoteTxt.setText(quotesLists.get(currentQuotePositon).getQuote());

        writerName.setText(quotesLists.get(currentQuotePositon).getWriter());
    }
}