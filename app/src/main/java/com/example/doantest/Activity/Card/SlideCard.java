package com.example.doantest.Activity.Card;

import java.util.List;

public class SlideCard {
    private String nameSlide;
    private List<Card> cards;

    public SlideCard(String nameSlide, List<Card> cards) {
        this.nameSlide = nameSlide;
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getNameSlide() {
        return nameSlide;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setNameSlide(String nameSlide) {
        this.nameSlide = nameSlide;
    }
}
