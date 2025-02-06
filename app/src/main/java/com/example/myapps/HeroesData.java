package com.example.myapps;

import  com.example.myapps.R;
import java.util.ArrayList;

public class HeroesData {
    private static String[]heroesNames ={
            "Soekarno",
            "Soedirman",
            "Habibie"
    };

    private static String[] heroesDetail = {
            "Soekarno adalah Presiden pertama Republik Indonesia yang memproklamasikan kemerdekaan pada 17 Agustus 1945 bersama Mohammad Hatta. Soekarno adalah tokoh besar yang memiliki visi nasionalisme tinggi, memperjuangkan kemerdekaan Indonesia, serta meletakkan dasar-dasar negara Indonesia yang merdeka dan berdaulat.",
            "Jenderal Soedirman adalah pahlawan nasional Indonesia yang dikenal sebagai pemimpin tentara Indonesia dalam perang kemerdekaan melawan penjajah Belanda. Meski dalam keadaan sakit, beliau tetap memimpin pasukan dengan semangat tinggi dan memainkan peran penting dalam pertempuran melawan penjajahan.",
            "B.J. Habibie adalah Presiden ketiga Republik Indonesia yang terkenal dengan kecerdasannya dalam bidang teknologi. Sebelum menjabat Presiden, Habibie adalah seorang insinyur yang berperan dalam pengembangan industri penerbangan Indonesia. Di masa pemerintahannya, beliau banyak melakukan reformasi politik dan ekonomi di Indonesia."
    };

    private static int[] heroImages = {
            R.drawable.soekarno,
            R.drawable.soedirman,
            R.drawable.habibie
    };

    static ArrayList<Hero> getListData() {
        ArrayList<Hero> list = new ArrayList<>();
        for (int position = 0; position < heroesNames.length; position++) {
            Hero hero = new Hero();
            hero.setNama(heroesNames[position]);
            hero.setDetail(heroesDetail[position]);
            hero.setPhoto(heroImages[position]);
            list.add(hero);
        }
        return list;  // Moved return statement outside of the loop
    }
}