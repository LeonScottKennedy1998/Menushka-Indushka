package com.example.hz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Button buttonPopup = view.findViewById(R.id.buttonMenu);

        buttonPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.increment_counter) {
                    counter++;
                    Toast.makeText(getActivity(), "Счётчик: " + counter, Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.reset_counter) {
                    counter = 0;
                    Toast.makeText(getActivity(), "Счётчик сброшен", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            });

            popupMenu.show();
        });
        return view;
    }
}
