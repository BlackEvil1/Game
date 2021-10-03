package tutorials;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //создаем врагов и указываем такие параметры, как: макисмальное здоровье и урон
        String[] enemies = {"Волк", "Медведь", "Лис", "Ворон"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // игрок и его параметры
        int health = 80;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("\tДобро пожаловать! " +
                "\n\tТы путешествуешь и вдруг видишь, как из кустов на тебя кто-то прыгает...");

        //GAME:
        while (running) {
            System.out.println("\t-----------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " нападает! #\n");

            //предлагаем игроку выбрать действие
            while (enemyHealth > 0) {
                System.out.println("\tТвое здоровье: " + health);
                System.out.println("\t" + enemy + " HP:" + enemyHealth);
                System.out.println("\n\t Что будешь делать дальше?");
                System.out.println("\t1. Атаковать");
                System.out.println("\t2. Подлечиться");
                System.out.println("\t3. Убежать");

                //последствия того, когда игрок выбирает атаку
                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> Ты нанес персонажу " + enemy + " " + damageDealt + " единиц(ы) урона");
                    System.out.println("\t> Ты получил " + damageTaken + " единиц(ы) урона");

                    if (health < 1) {
                        System.out.println("\tТы истекаешь кровью и начинаешь терять сознание, лучше бежать!");
                        break;
                    }
                }
                //последствия того, когда игрок выбирает подлечиться
                else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health +=healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> Ты подлечился, твое здоровье пополнено на: " + healthPotionHealAmount + " единиц(ы)"
                                            +"\n\t> У тебя сейчас " + health + " единиц(ы) здоровья"
                                            +"\n\t> У тебя осталось " + numHealthPotions + " единиц(ы) зелья");
                    }
                    else {
                        System.out.println("\t> У тебя не закончились зелья здоровья");
                    }
                }
                //последствия того, когда игрок выбирает бежать
                else if (input.equals("3")) {
                    System.out.println("\tТы правда решил убежать? Ну уж нет, дерись! \n");
                    continue;
                } else {
                    System.out.println("\tКоманда не распознана, попробуй еще раз \n");
                }
            }
            //если здоровье меньше 1, тогда персонаж прячется, после чего его исход никому не известен (будем надеяться, что он выжил)
            if (health < 1) {
                System.out.println("\tТы решаешь, что лучше спрятаться, больше тебя никто не видел...");
                break;
            }
            //сообщение, когда игрок побеждает врага
            System.out.println("-----------------------------------------------------------");
            System.out.println(" # " + enemy + " был побежден! # ");
            System.out.println(" # У тебя осталось " + health + " единиц(ы) здоровья # ");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # С персонажа: " + enemy + " упало зелье здоровья # " );
                System.out.println(" # И того у тебя сейчас " + numHealthPotions + " единиц(ы) зелья здоровья # ");
            }
            //снова даем выбор игроку
            System.out.println("-----------------------------------------------------------");
            System.out.println("Что будешь делать дальше?");
            System.out.println("1. Продолжить приключение");
            System.out.println("2. Уйти с гордостью");

            String input = in.nextLine();

            while (!input.equals("1") && ! input.equals("2")) {
                System.out.println("Команда не распознана, попробуй еще раз \n");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("Приключеия только начинаются, вперед!");
            }
            else if(input.equals("2")) {
                System.out.println("Прощай!");
                break;
            }
        }
    }
}