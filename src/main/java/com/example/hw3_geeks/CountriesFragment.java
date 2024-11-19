package com.example.hw3_geeks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.List;

public class CountriesFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCountries);

        String selectedContinent = getArguments() != null ? getArguments().getString("continent") : "";

        List<Item> countries = getCountriesForContinent(selectedContinent);

        ItemAdapter adapter = new ItemAdapter(requireContext(), countries, item -> {
            CitiesFragment citiesFragment = new CitiesFragment();

            Bundle args = new Bundle();
            args.putString("country", item.getText());
            citiesFragment.setArguments(args);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, citiesFragment)
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Item> getCountriesForContinent(String continent) {
        // Return countries based on the continent selected
        if ("Евразия".equals(continent)) {
            return Arrays.asList(
                    new Item("Казахстан", 0),
                    new Item("Россия", 0)
            );
        }
        // Add more continents and countries as needed
        return Arrays.asList();
    }
}
