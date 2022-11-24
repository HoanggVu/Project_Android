package com.example.doantest.Activity.Card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantest.Activity.MainActivity;
import com.example.doantest.Activity.Menu.Menu;
import com.example.doantest.Activity.Menu.MenuAdapter;
import com.example.doantest.R;

import java.util.List;

public class SlideCardAdapter extends RecyclerView.Adapter<SlideCardAdapter.SlideCardVewHoler>{

    private Context mContext;
    private List<SlideCard> mSlideCard;
    public SlideCardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<SlideCard> list){
        this.mSlideCard = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SlideCardVewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_card, parent, false);
        return new SlideCardVewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideCardVewHoler holder, int position) {
        SlideCard slideCard = mSlideCard.get(position);
        if (slideCard == null){
            return;
        }
        holder.tv_slideCard.setText(slideCard.getNameSlide());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvCard.setLayoutManager(linearLayoutManager);

        CardAdapter cardAdapter = new CardAdapter();
        cardAdapter.setData(slideCard.getCards(), new CardAdapter.IClickAddToCart() {
            @Override
            public void OnClickAddToCart(ImageView imgAddToCart, Card card) {
                Toast.makeText(mContext, "Check", Toast.LENGTH_SHORT).show();
            }
        });
        holder.rcvCard.setAdapter(cardAdapter);
    }

    @Override
    public int getItemCount() {
        if (mSlideCard != null){
            return mSlideCard.size();
        }
        return 0;
    }

    public  class SlideCardVewHoler extends RecyclerView.ViewHolder{

        private TextView tv_slideCard;
        private RecyclerView rcvCard;

        public SlideCardVewHoler(@NonNull View itemView) {
            super(itemView);

            tv_slideCard = itemView.findViewById(R.id.tv_sl_card);
            rcvCard = itemView.findViewById(R.id.rcv_slide_card);
        }
    }
}
