import java.util.*;
import java.io.*;

class Solution {
    static String skill;
    static String[] skill_trees;
    public int solution(String skill, String[] skill_trees) {
        int cnt = 0; // 정답(갯수)
        this.skill = skill;

        
        
        
        
        label:for(String skill_tree : skill_trees){ // 스킬트리 전체 for문
            int index = 0; // index (skill의 순번)
            
            for(int i=0; i<skill_tree.length(); i++){ // skill_tree 길이만큼 반복문
                // skill_tree.charAt(i) skill.charAt(index)과 비교
                if(isNotInSkill(skill_tree.charAt(i))) continue; // 만약 skill 안에 없으면 패스
                // 안에 있으면
                System.out.println(skill_tree+" "+skill_tree.charAt(i)+" " +skill.charAt(index));
                // 다르면 끝 안쪽 for문 끝내기
                if(skill_tree.charAt(i) != skill.charAt(index)) { 
                    continue label;
                }else{ // skill index번째랑 skill_tree.charAt(i)이 같으면 다음i index++;
                    index++;
                }
                // 만약 skill_trees[i]가 다 만족하면(index가 스킬길이랑 같으면) cnt ++; break;
                if(index>=skill.length()) {
                    cnt++;
                    System.out.println(cnt);
                    continue label;
                }
            }
            cnt++;
            System.out.println(cnt);
        }
        
        return cnt;
    }
    
    static boolean isNotInSkill(char c){
        int n = skill.length();
        for(int i=0; i<n; i++){
            if(skill.charAt(i) == c) return false;
        }
        return true;
    }
}