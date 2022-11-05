package de.tu_dortmund.vki.modules.dap1.utils.uebung03;

public class MultipleStrings {
    private String[] texts;

    public MultipleStrings(int n) {
        this.texts = new String[Math.abs(n)];
    }

    public boolean addAtPosition(String s, int p) {
        if(p >= 0 && p < this.texts.length) {
            this.texts[p] = s;
            return true;
        }
        return false;
    }

    public int size() {
        return this.texts.length;
    }

    public int realSize() {
        int count = 0;
        for (String text : this.texts) {
            if(text != null) {
                count++;
            }
        }

        return count;
    }

    public int atEnd(String end) {
        int count = 0;
        for (String text :
                texts) {
            if(text != null) {
                if (text.lastIndexOf(end) == text.length() - end.length()) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean inAll(char ch) {
        boolean isInAll = true;
        for (String text :
                texts) {
            if(text != null) {
                if(!text.contains("" + ch)) {
                    isInAll = false;
                }
            }
        }

        return isInAll;
    }

    public void replace(char ch, char rep) {
        for(int i = 0; i < this.texts.length; i++) {
            if(texts[i] != null) {
                this.texts[i] = this.texts[i].replace(ch , rep);
            }
        }
    }

    public String toString() {
        String result = "";
        for(int i = 0; i < this.texts.length; i++) {
            result += "Pos " + i + ": [";
            if(this.texts[i] != null) {
                result += this.texts[i];
            }
            result += "] ";
        }

        return result;
    }
}
