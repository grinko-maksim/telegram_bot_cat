package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "t.me/MSGrinko_java_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "6937307507:AAF_DtZ8wYWnfott3UBQb2f4tkHWdX6qOYo"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь

        //Урок 1
        // sendTextMessageAsync("Привет!");
        //sendTextMessageAsync("*Привет, Я научу тебя ЯП Java!*");
        //sendTextMessageAsync("Привет, _Я научу тебя ЯП Java!_");

        //Урок 2
//        if(getMessageText().equals("/start")) {
//            sendTextMessageAsync("Привет!");
//        }
//        if(getMessageText().equals("/bye")) {
//            sendTextMessageAsync("Asta la vista, baby!");
//        }
//        if(getMessageText().equals("How are you?")){
//            sendTextMessageAsync("Great! Thanks) And you?");
//        }
//        if(getMessageText().contains("бомба")){
//            sendTextMessageAsync("Опасность");
//        }
//        if(getMessageText().contains("картинка")){
//            sendPhotoMessageAsync("step_1_pic");
//        }
//        if(getMessageText().contains("кот")){
//            sendTextMessageAsync("Выбери номер кота:", Map.of("кот 1","cat1", "кот 2", "cat2"));
//        }
//        if(getCallbackQueryButtonKey().equals("cat1")){
//            sendPhotoMessageAsync("step_3_pic");
//        }
//        if(getCallbackQueryButtonKey().equals("cat2")){
//            sendPhotoMessageAsync("step_2_pic");
//        }
//        if(getMessageText().equals("smile")){
//            var message = getLastSentMessage();
//            editTextMessageAsync(message.getMessageId(), message.getText()+" :) ");
//        }
//        if (getMessageText().contains("Животное")){
//            sendTextMessageAsync("Ваше любимое животное?", Map.of("Кот", "Кот", "Собка", "Собака"));
//        }
//        if (getCallbackQueryButtonKey().equals("Кот")){
//            sendPhotoMessageAsync("step_4_pic");
//        }
//        if (getCallbackQueryButtonKey().equals("Собака")){
//            sendPhotoMessageAsync("step_6_pic");
//            }
        //Урок 3

        //Отобразим сообщение о начале игры - нужно взломать холодильник
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT, Map.of("Взять сосиску! + 20 славы", "step_2_btn",
                    "Взять рыбку! + 20 славы", "step_2_btn",
                    "Скинуть банку с огурцами! + 20 славы", "step_2_btn"));
        }

        //Взламываем робот пылесос
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робот-пылесос", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT, Map.of(
                    "Отправить робот пылесос за едой! + 30 славы", "step_4_btn",
                    "Покататься на роботе пылесосе! + 30 славы", "step_4_btn",
                    "Убежать от робота пылесоса! + 30 славы", "step_4_btn"));
        }

        //Взламываем камеру Go-Pro

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Включить и надеть камеру Go-Pro", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT, Map.of(
                    "Бегать по крышам и снимать!+ 40 славы!", "step_6_btn",
                    "Нападат на кошек и снимать!+ 40 славы", "step_6_btn",
                    "Нападат на собак и снимать!+ 40 славы", "step_6_btn"));
        }

        //Взламываем компьютер
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом компьютера!", "step_7_btn"));
        }

        //Хвастаемся дворовым котам
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Выйти во двор и похвастаться всем!", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);

        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}