package com.example.doantest.Activity.Menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantest.Activity.Card.SlideCard;
import com.example.doantest.R;

import java.util.List;

public class MenuAdapter extends  RecyclerView.Adapter<MenuAdapter.MenuViewHoler> {

    private Context mContext;
    private List<Menu> mMenu;
    private IClickAddToCart iClickAddToCart;

    public MenuAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public interface IClickAddToCart{
        void OnClickAddToCart(ImageView imgAddToCart, Menu menu );
    }
    public void setData(List<Menu> list, IClickAddToCart ClickAddToCart ){
        this.mMenu = list;
        this.iClickAddToCart = ClickAddToCart;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu, parent, false);
        return new MenuViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHoler holder, int position) {
        Menu menu = mMenu.get(position);
        if (menu == null){
            return;
        }
        holder.img_menu.setImageResource(menu.getResourceImage());
        holder.tv_title_menu.setText(menu.getTitle());
        holder.tv_price_menu.setText(menu.getPrice());

        holder.imgAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickAddToCart.OnClickAddToCart(holder.imgAddToCart, menu);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mMenu != null){
            return mMenu.size();
        }
        return 0;
    }

    public  class MenuViewHoler extends RecyclerView.ViewHolder{

        private TextView tv_title_menu, tv_price_menu;
        private ImageView img_menu, imgAddToCart;

        public MenuViewHoler(@NonNull View itemView) {
            super(itemView);

            img_menu = itemView.findViewById(R.id.img_menu);
            tv_price_menu = itemView.findViewById(R.id.tv_price_menu);
            tv_title_menu = itemView.findViewById(R.id.tv_title_menu);
            imgAddToCart = itemView.findViewById(R.id.img_addtocart);
        }
    }
}
