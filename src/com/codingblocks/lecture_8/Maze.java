package com.codingblocks.lecture_8;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {

        ArrayList<String> list = mazePathReturn(new ArrayList<>(), "", 3, 3);

        System.out.println(list);
    }

    public static int maze(int row, int col){
        if (row == 1 && col == 1){
            return 1;
        }

        int count = 0;

        if (row > 1) {
            count += maze(row - 1, col);
        }

        if (col > 1) {
            count += maze(row, col - 1);
        }

        return count;
    }

    public static void mazePath(String path, int row, int col){
        if (row == 1 && col == 1){
            System.out.println(path);
            return;
        }

        if (row > 1){
            mazePath(path + "V", row - 1, col);
        }

        if (col > 1){
            mazePath(path + "H", row, col - 1);
        }
    }

    public static void mazePathBuilder(StringBuilder path, int row, int col){
        if (row == 1 && col == 1){
            System.out.println(path);
            return;
        }

        if (row > 1){
            path.append("V");
            mazePathBuilder(path, row - 1, col);
            path.deleteCharAt(path.length() - 1);
        }

        if (col > 1){
            path.append("H");
            mazePathBuilder(path, row, col - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static ArrayList<String> mazePathReturn(ArrayList<String> list, String path, int row, int col){
        if (row == 1 && col == 1){
            list.add(path);
            return list;
        }

        if (row > 1){
            mazePathReturn(list, path + "V", row - 1, col);
        }

        if (col > 1){
            mazePathReturn(list, path + "H", row, col - 1);
        }

        return list;
    }
}
