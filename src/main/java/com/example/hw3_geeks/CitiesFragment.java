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
import android.widget.Toast;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitiesFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cities, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCities);

        String selectedCountry = getArguments() != null ? getArguments().getString("country") : "";

        List<Item> cities = getCitiesForCountry(selectedCountry);

        ItemAdapter adapter = new ItemAdapter(requireContext(), cities, item -> {
            FullScreenImageDialog fullScreenImageDialog = FullScreenImageDialog.newInstance(item.getImageResId());
            fullScreenImageDialog.show(getParentFragmentManager(), "full_screen_image");
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Item> getCitiesForCountry(String country) {
        // Return cities based on the country selected
        if ("Казахстан".equals(country)) {
            return Arrays.asList(
                    new Item("Алматы", R.drawable.almaty),
                    new Item("Нур-Султан", R.drawable.nur_sultan),
                    new Item("Шымкент", R.drawable.shymkent)
            );
        } else if ("Россия".equals(country)) {
            return Arrays.asList(
                    new Item("Москва", R.drawable.moscow),
                    new Item("Санкт-Петербург", R.drawable.spb),
                    new Item("Казань", R.drawable.kazan)
            );
        }
        return Arrays.asList();
    }
}
