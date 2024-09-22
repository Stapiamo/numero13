package com.example.numero13;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate de que este sea el nombre de tu layout

        Button buttonComenzar = findViewById(R.id.Primerboton);
        buttonComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cargar el fragmento
                MyFragment myFragment = new MyFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, myFragment);
                transaction.addToBackStack(null); // Para poder volver atrás si es necesario
                transaction.commit();
            }
        });
    }
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate de que este sea el nombre de tu layout

        recyclerView = findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista de URLs de imágenes (reemplaza estos enlaces con tus propias imágenes)
        List<String> imageUrls = Arrays.asList(
                R.drawable.foto1,
                R.drawable.foto2,
                R.drawable.foto3,
                R.drawable.foto4,
                R.drawable.foto5,
                R.drawable.foto6,
        );

        imageAdapter = new ImageAdapter(imageUrls, this);
        recyclerView.setAdapter(imageAdapter);
    }
}
}