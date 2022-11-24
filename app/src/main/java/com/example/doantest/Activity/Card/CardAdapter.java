package com.example.doantest.Activity.Card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantest.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHoler>{

    private List<Card> mCards;

    private IClickAddToCart iClickAddToCart;

    public interface IClickAddToCart{
        void OnClickAddToCart(ImageView imgAddToCart, Card card );
    }
    public void setData(List<Card> list, IClickAddToCart iClickAddToCart ){
        this.mCards  = list;
        this.iClickAddToCart = iClickAddToCart;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new CardViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHoler holder, int position) {
        Card card = mCards.get(position);
        if (card == null){
            return;
        }
        holder.img_card.setImageResource(card.getResourceId());
        holder.tv_title_card.setText(card.getTitle());
        holder.tv_price_card.setText(card.getPrice());
        holder.imgAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickAddToCart.OnClickAddToCart(holder.imgAddToCart, card);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mCards != null){
            return mCards.size();
        }
        return 0;
    }

    public  class CardViewHoler extends RecyclerView.ViewHolder{

        private TextView tv_title_card, tv_price_card;
        private ImageView img_card, imgAddToCart;


        public CardViewHoler(@NonNull View itemView) {
            super(itemView);

            tv_title_card = itemView.findViewById(R.id.tv_title_card);
            tv_price_card = itemView.findViewById(R.id.tv_price_card);
            img_card = itemView.findViewById(R.id.img_card);
            imgAddToCart = itemView.findViewById(R.id.img_addtocart);
        }
    }
}
