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

public class ContinentsFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull Lay outInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continents, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewContinents);

        List<Item> continents = Arrays.asList(
                new Item("Евразия", 0),
                new Item("Африка", 0),
                new Item("Америка", 0),
                new Item("Австралия", 0),
                new Item("Антарктида", 0)
        );

        ItemAdapter adapter = new ItemAdapter(requireContext(), continents, item -> {
            CountriesFragment countriesFragment = new CountriesFragment();

            Bundle args = new Bundle();
            args.putString("continent", item.getText());
            countriesFragment.setArguments(args);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, countriesFragment)
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
