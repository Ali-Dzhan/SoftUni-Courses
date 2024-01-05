package ExamPrepFinal1;

import java.util.*;

public class P04ThePianist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> composeByPiece = new LinkedHashMap<>();
        Map<String, String> keyByPiece = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] parts = scanner.nextLine().split("\\|");

            String piece = parts[0];
            String composer = parts[1];
            String key = parts[2];

            composeByPiece.put(piece, composer);
            keyByPiece.put(piece, key);

        }
        while(true){
            String line = scanner.nextLine();
            if(line.equals("Stop")){
                break;
            }
            String[] commandParts = line.split("\\|");
            String command = commandParts[0];

            switch (command){
                case "Add":
                    String piece = commandParts[1];
                    String composer = commandParts[2];
                    String key = commandParts[3];
                    if(composeByPiece.containsKey(piece)){
                        System.out.printf("%s is already in the collection!\n", piece);
                    } else {
                        composeByPiece.put(piece, composer);
                        keyByPiece.put(piece, key);

                        System.out.printf("%s by %s in %s added to the collection!\n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    String pieceRemove = commandParts[1];
                    if(!composeByPiece.containsKey(pieceRemove)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceRemove);
                    } else {
                        composeByPiece.remove(pieceRemove);
                        keyByPiece.remove(pieceRemove);

                        System.out.printf("Successfully removed %s!\n", pieceRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceChange = commandParts[1];
                    String newKey = commandParts[2];

                    if(!composeByPiece.containsKey(pieceChange)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceChange);
                    } else {
                        keyByPiece.put(pieceChange, newKey);

                        System.out.printf("Changed the key of %s to %s!\n", pieceChange, newKey);
                    }
                    break;
            }
        }

       /* composeByPiece
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<String, String> e) -> e.getValue()).thenComparing(Map.Entry::getKey))
                .forEach((e) ->{
                        String piece = e.getKey();
                        String composer = e.getValue();
                        String key = keyByPiece.get(piece);
                        System.out.printf("%s -> Composer: %s, Key: %s\n", piece, composer, key);
                });

        */

        for (Map.Entry<String, String> entry : composeByPiece.entrySet()){
            String piece = entry.getKey();
            String composer = entry.getValue();
            String key = keyByPiece.get(piece);
            System.out.printf("%s -> Composer: %s, Key: %s\n", piece, composer, key);
        }

    }
}
