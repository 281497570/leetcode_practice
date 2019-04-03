package org.lj.ds.hash;

import lombok.extern.slf4j.Slf4j;

/**
 * 有效异字母位，判断两个字符串里出现的字母数量是否相同 <br>
 * ValidAnagram <br>
 * https://leetcode.com/problems/valid-anagram/ <br>
 */
@Slf4j
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "managra", t = "nagaran";
        log.info("s:{}, t:{}, isValid:{}", s, t, new ValidAnagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        byte[] table = new byte[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
