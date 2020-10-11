package com.example.pokemon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokemon.models.Pokemon;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonListAdapter extends  RecyclerView.Adapter<PokemonListAdapter.ViewHolder>{

    private ArrayList<Pokemon> dataset;
    private Context context;

    public PokemonListAdapter(Context context){
        dataset = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.nameTextView.setText(p.getName());

        Picasso.with(context).load("https://www.pngonly.com/wp-content/uploads/2017/06/hd-pokemon-png-10203.png").into(holder.photoImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addPokemonList(ArrayList<Pokemon> pokemonList){
        dataset.addAll(pokemonList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView photoImageView;
        private TextView nameTextView;

        public ViewHolder (View itemView){
            super(itemView);
photoImageView = itemView.findViewById(R.id.photoImageView);
nameTextView = itemView.findViewById(R.id.nameTextView);
        }

    }
}
