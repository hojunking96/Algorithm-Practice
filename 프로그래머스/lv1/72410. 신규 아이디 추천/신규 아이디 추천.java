class Solution {
    public String solution(String new_id) {
  char[] letters;
        String tmp = "";
        letters = new_id.toCharArray();
        for (int i = 0; i < new_id.length(); i++) {
            letters[i] = new_id.charAt(i);
        }

        for (int i = 0; i < new_id.length(); i++) {
            if (letters[i] >= 'A' && letters[i] <= 'Z') {
                letters[i] = (char) (letters[i] - 'A' + 'a');
            }
        }
        for (int i = 0; i < new_id.length(); i++) {
            if (letters[i] >= 'a' && letters[i] <= 'z' || letters[i] == '-' || letters[i] == '_'
                    || letters[i] == '.' || letters[i] >= '0' && letters[i] <= '9') {
                continue;
            }
            letters[i] = 'X';
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 'X') {
                tmp += letters[i];
            }
        }
        letters = tmp.toCharArray();

        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == '.' && letters[i + 1] == '.') {
                letters[i] = 'X';
            }
        }
        tmp = "";
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 'X') {
                tmp += letters[i];
            }
        }
        if (tmp.charAt(0) == '.') {
            tmp = tmp.substring(1);
        }
        if (!tmp.equals("")) {
            if (tmp.charAt(tmp.length() - 1) == '.') {
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
        if (tmp.equals("")) {
            tmp = "a";
        }
        if (tmp.length() >= 16) {
            tmp = tmp.substring(0, 15);
        }
        if (tmp.charAt(tmp.length() - 1) == '.') {
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        while (tmp.length() < 3) {
            tmp += tmp.charAt(tmp.length() - 1);
        }
        return tmp;
    }
}