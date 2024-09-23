package com.rafalopez.tpo4.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafalopez.tpo4.MainActivity;
import com.rafalopez.tpo4.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ItemAdapter itemAdapter = new ItemAdapter( MainActivity.farmacias,inflater);

        GridLayoutManager grid=new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        RecyclerView reciclerView= binding.lista;
        reciclerView.setAdapter(itemAdapter);
        reciclerView.setLayoutManager(grid);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}