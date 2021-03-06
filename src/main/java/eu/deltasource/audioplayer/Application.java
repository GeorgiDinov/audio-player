package eu.deltasource.audioplayer;

//Тема 2: Audio Player XL2
//        Ще направим същата задача като `Задача 1`, но ще създадем допълнителен клас `Song`.
//        В конструкторите, задайте стойности по подразбиране (вие изберете какви). Избирайте
//        подходящи имена на методите, както и подходящи типове на резултатите. Създайте клас
//        `Application`, който трябва да е стартовия файл на програмата ни.
//        Не забравяйте да оставяте коментари!
//
//        1. Създайте клас `Song`. Създайте няколко член-променливи, като прецените сами какъв
//        тип трябва да бъдат
//        - `title` - заглавие на песента
//        - `author` - автор
//        - `genre` - жанр
//        - `timing` - времетраене на песента
//        Напишете метод, който да извежда в конзолата характеристиките на класа.
//        Напишете метод, който да извежда в конзолата форматирано заглавието на песента и
//        автора.
//
//        2. Създайте клас `AudioPlayer`. Създайте няколко instance променливи, като прецените
//        сами какъв тип трябва да бъдат
//        - `songs` - всички песни
//----------------------------------------------------------------------------------
//        Напишете метод, който да извежда в конзолата характеристиките на класа.

//        Напишете метод, който да стартира изпълнението на песните последователно.

//        Напишете метод, който да спира изпълнението на песните и след последващо
//        стартиране да започват от начало.

//        Напишете метод, който да прави пауза на текущата песен и след последващото
//        стартиране да продължава от същата песен.

//        Напишете метод, който трябва да стартира следваща песен.

//        Напишете метод, който трябва да стартира предишна песен.

//        Напишете метод, който трябва да изпълнява песните разбъркано.

//        Напишете метод, който трябва да изписва в конзолата коя подред е песента, която в
//        момента се изпълнява, както и нейните заглавие и изпълнител.!!!!!!!!!!!!!
//--------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------
//        Напишете метод, който трябва да търси по заглавие и да извежда в конзолата името на
//        изпълнителя, ако е намерено съвпадение и коя подред е.

//        Напишете метод, който трябва да търси по изпълнител и да извежда в конзолата всички
//        негови песни.
//        Напишете метод, който трябва да извежда в конзолата броят на всички песни.
//        Напишете метод, който може да добавя нова песен.
//        Напишете метод, който може да премахва песен.
//-----------------------------------------------------------------------------------------

import eu.deltasource.audioplayer.player.Player;
import eu.deltasource.audioplayer.player.PlayerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

import static eu.deltasource.audioplayer.util.Color.ANSI_WHITE;
import static eu.deltasource.audioplayer.util.StandardPlayerSymbols.*;

public class Application {

    public static void main(String[] args) {

        Player player = PlayerFactory.createPlayer("audio");

        work(player);

    }


    private static void work(Player player) {
        Thread thread;
        boolean quit = false;
        int choice;
        printMenuOptions();
        while (!quit) {

            choice = getInt();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    thread = new Thread(player::playAll);
                    thread.start();
                    break;
                case 2:
                    player.setShuffled(true);
                    thread = new Thread(player::playAll);
                    thread.start();
                    break;
                case 3:
                    player.setPaused(true);
                    break;
                case 4:
                    player.setStopped(true);
                    break;
                case 5:
                    player.playNext(true);
                    break;
                case 6:
                    player.playPrevious(true);
                    break;
                case 7:
                    printMenuOptions();
                    break;
                default:
                    break;
            }
        }
    }

    private static void printMenuOptions() {
        System.out.println(
                ANSI_WHITE + "Press: \n" +
                        "\t0 -> to Quit The Application\n" +
                        "\t1 -> to " + PLAY + "\n" +
                        "\t2 -> to " + PLAY + " Shuffled\n" +
                        "\t3 -> to " + PAUSE + " / " + PLAY + "\n" +
                        "\t4 -> to " + STOP + "\n" +
                        "\t5 -> to " + PLAY_NEXT + "\n" +
                        "\t6 -> to " + PLAY_PREVIOUS + "\n" +
                        "\t7 -> to print the Menu Options\n");
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Choose operation: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

}
