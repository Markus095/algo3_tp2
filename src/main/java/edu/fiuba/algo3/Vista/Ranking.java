package edu.fiuba.algo3.Vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Ranking {
    private HashMap<String, Integer> ranking;
    private ObservableList<InfoJugada> rankingList;
    public Ranking() throws IOException {
        this.inicializarRanking();
    }
    public void agregarPartida(int cantidadMovimientos, String nombreJugador) throws IOException {
        if (ranking.containsKey(nombreJugador) & ranking.get(nombreJugador) > cantidadMovimientos) {
            cantidadMovimientos = ranking.get(nombreJugador);
        }
        ranking.put(nombreJugador, cantidadMovimientos);
        this.crear_archivo();
    }

    private void inicializarRanking() throws IOException {
        this.ranking = new HashMap<String, Integer>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/ranking.csv"));
        String row = csvReader.readLine();

        while (row != null) {
            String[] data = row.split(",");
            ranking.put(data[0], Integer.valueOf(data[1]));
            row = csvReader.readLine();
        }
        csvReader.close();
    }
    private void crear_archivo() throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/ranking.csv");
        ranking = sortByValue(ranking);
        this.rankingList = FXCollections.observableArrayList();

        int i = 1; // todo arreglar esto feo
        for(Map.Entry<String, Integer> entry: ranking.entrySet()) {
            csvWriter.append(entry.getKey() + ',' + entry.getValue());
            csvWriter.append("\n");
            this.rankingList.add(new InfoJugada(entry.getKey(), entry.getValue(), i));
            i++;
        }
        csvWriter.flush();
        csvWriter.close();
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) { return (o1.getValue()).compareTo(o2.getValue()); }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) { temp.put(aa.getKey(), aa.getValue()); }

        return temp;
    }

    public ObservableList<InfoJugada> getRankingList() {
        return rankingList;
    }
}
