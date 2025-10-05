package com.example.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeckofCard {
public static void main(String[] args) {
	Card c1=new Card(Suit.diamond, Rank.ace);
	Card c2=new Card(Suit.club, Rank.king);
	System.out.println(c1.compareTo(c2)>0 ? c1:c2);
	Deck d=new Deck();
	d.sort();
	d.getCards().forEach(System.out::println);
}
}

enum Suit{
	heart,
	spade, club, diamond
}
enum Rank{
	ace(14), king(13), queen(12), jack(11);
	private final int value;

	private Rank(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}	
}

class Card implements Comparable<Card>{
	private final Suit suit;
	private final Rank rank;
	
	
	public Suit getSuit() {
		return suit;
	}
	public Rank getRank() {
		return rank;
	}
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	@Override
	public int compareTo(Card o) {
		return Integer.compare(this.rank.getValue(), o.rank.getValue());
	}
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}	
}



class Deck{
	private final List<Card> cards;

	public List<Card> getCards() {
		return cards;
	}

	public Deck() {
		cards=new ArrayList<>();
		for(Suit s:Suit.values()) {
			for(Rank r:Rank.values()) {
				cards.add(new Card(s, r));
			}	
		}
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public void sort() {
		cards.stream().sorted(Comparator.comparing(Card::getSuit).thenComparing(n-> n.getRank().getValue()));
	}
}