package com.example.mentalhealthquotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mentalhealthquotesapp.categories.CategoriesAdapter;
import com.example.mentalhealthquotesapp.categories.CategoriesList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<CategoriesList> categoriesLists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);
        categoriesRecyclerView.setHasFixedSize(true);
        categoriesRecyclerView.setLayoutManager( new GridLayoutManager(MainActivity.this, 2));

        // add categories to categoriesLists

        CategoriesList ADHDCategory = new CategoriesList("ADHD", R.drawable.adhd);
        categoriesLists.add(ADHDCategory); // add ADHD category to categoryLists



        // add categories to categoriesLists

        CategoriesList AnxietyCategory = new CategoriesList("Anxiety", R.drawable.anxiety);
        categoriesLists.add(AnxietyCategory); // add anxiety category to categoryLists


        // add categories to categoriesLists

        CategoriesList DepressionCategory = new CategoriesList("Depression", R.drawable.depression);
        categoriesLists.add(DepressionCategory); // add depression category to categoryLists


        // add categories to categoriesLists

        CategoriesList SubstanceCategory = new CategoriesList("Substance Abuse", R.drawable.substance);
        categoriesLists.add(SubstanceCategory); // add substance category to categoryLists


        // add categories to categoriesLists

        CategoriesList EatingCategory = new CategoriesList("Eating Disorder", R.drawable.eating);
        categoriesLists.add(EatingCategory); // add eating category to categoryLists


        CategoriesList PTSDCategory = new CategoriesList("PTSD", R.drawable.ptsd);
        categoriesLists.add(PTSDCategory);


        CategoriesList PersonalityCategory = new CategoriesList("Personality Disorders", R.drawable.personality);
        categoriesLists.add(PersonalityCategory);


        CategoriesList DissociationCategory = new CategoriesList("Dissociation", R.drawable.dissociation);
        categoriesLists.add(DissociationCategory);


        CategoriesList OCDcategory = new CategoriesList("OCD", R.drawable.ocd);
        categoriesLists.add(OCDcategory);

        CategoriesList ParanoiaCategory = new CategoriesList("Paranoia", R.drawable.paranoia);
        categoriesLists.add(ParanoiaCategory);

        CategoriesList SchizophreniaCategory = new CategoriesList("Schizophrenia", R.drawable.schizophrenia);
        categoriesLists.add(SchizophreniaCategory);

        CategoriesList PsychosisCategory = new CategoriesList("Psychosis", R.drawable.psychosis);
        categoriesLists.add(PsychosisCategory);


    // set adapter to recyclerView

        categoriesRecyclerView.setAdapter(new CategoriesAdapter(categoriesLists, MainActivity.this));

    }
}