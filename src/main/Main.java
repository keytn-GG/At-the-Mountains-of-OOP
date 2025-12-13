package main;

import java.util.Scanner;

import character.Character;
import character.CharacterBuilder;
import character.CharacterSpec;
import character.CharacterUI;

public class Main {
    public static void main(String[] args) {
//        Scannerを準備
        Scanner sc = new Scanner(System.in);
        
        CharacterUI ui = new CharacterUI(sc);
        CharacterSpec spec = ui.createSpec();
        
        CharacterBuilder builder = new CharacterBuilder();
        Character player = builder.build(spec);
        
        player.showStatus();
    }
}
