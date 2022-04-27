package com.syed.homework.homework0329;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import org.apache.commons.collections4.ListUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description：
 *
 * @author USER
 * @date 2022/3/29
 */
public class CelsService {
    public static void main(String[] args) throws IOException {
        Map<Character, List<Word>> allWords = getAllWords();
        List<Map.Entry<Character, List<Word>>> mapToList = new ArrayList<>(allWords.entrySet());
        batchDealDataOfWord(mapToList, 10, 'C',1);

//        List<Vocabulary> allVocabularies = getAllVocabularies();
//        batchDealDataOfVocabulary(allVocabularies, 10);

    }

    /**
     * 查询所有的单词,并且按照首字母分类存放
     */
    public static Map<Character, List<Word>> getAllWords() throws IOException {
        Map<Character, List<Word>> wordMap = null;
        //读取w.dic文件,把文件中每一行的数据当做一个字符串放入到集合中
        List<String> words = Files.readAllLines(Paths.get("src/com/syed/homework/homework0329/w.dic"));
        //字符串处理,封装一个Word对象,然后按照首字母存入到map集合中
        if (words.size() > 0) {
            wordMap = new HashMap<>();
            for (String e : words) {
                Word word = CelsService.getWord(e);
                if (!wordMap.containsKey(word.getFirstLetter())) {
                    List<Word> wordList = new ArrayList<>();
                    wordList.add(word);
                    wordMap.put(word.getFirstLetter(), wordList);
                } else {
                    wordMap.get(word.getFirstLetter()).add(word);
                }
            }
        }
        return wordMap;
    }

    /**
     * 拿到指定首字母对应的所有的单词,要求分页显示单词,每页显示10个
     *
     * @param data
     * @param batchNum
     */
    public static void batchDealDataOfWord(List<Map.Entry<Character, List<Word>>> data, int batchNum, Character ch, int page) {
        for (Map.Entry<Character, List<Word>> entry : data) {
            if (entry.getKey().equals(ch)) {
                List<List<Word>> anyPageBatchNumWords = ListUtils.partition(entry.getValue(), batchNum);
//                for (List<Word> words : anyPageBatchNumWords) {
//                    for (Word word : words) {
//                        System.out.println(String.format("%-10s", word.getEn()) + "\t\t" + word.getCns());
//                    }
//                    System.out.println("-----------------------下一页---------------------");
//                }
                List<Word> words = anyPageBatchNumWords.get(page - 1);
                for (Word word : words) {
                        System.out.println(String.format("%-10s", word.getEn()) + "\t\t" + word.getCns());
                    }
            }
        }
    }


    /**
     * 得到每个Word对象
     *
     * @param src
     * @return
     */
    public static Word getWord(String src) {
        Word word = null;
        if (src != null && src.length() > 0) {
            //获取英文
            String wordEn = src.split(" ")[0];
            //获取中文
            String[] wordCh = src.split("[ :]");
            wordCh = ArrayUtil.sub(wordCh, 1, wordCh.length);
            //转换为集合
            ArrayList<String> chinese = CollectionUtil.toList(wordCh);
            //
            word = new Word(wordEn, chinese);
        }
        return word;
    }


    /**
     * 查询所有的词汇
     *
     * @return
     */
    public static List<Vocabulary> getAllVocabularies() {
        List<Vocabulary> vocabulariesList = null;
        //读取w.dic文件,把文件中每一行的数据当做一个字符串放入到集合中
        try {
            List<String> vocabularies = Files.readAllLines(Paths.get("src/com/syed/homework/homework0329/v.dic"));
            //字符串处理,封装一个Word对象,然后按照首字母存入到map集合中
            if (vocabularies.size() > 0) {
                vocabulariesList = new ArrayList<>();
                for (String e : vocabularies) {
                    Vocabulary vocabulary = getVocabulary(e);
                    vocabulariesList.add(vocabulary);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vocabulariesList;
    }

    /**
     * 每页显示10个词汇
     *
     * @param data
     * @param batchNum
     */
    public static void batchDealDataOfVocabulary(List<Vocabulary> data, int batchNum) {
        List<List<Vocabulary>> anyPageBatchNumVocabularies = ListUtils.partition(data, batchNum);
        for (List<Vocabulary> vocabularies : anyPageBatchNumVocabularies) {
            for (Vocabulary vocabulary : vocabularies) {
                System.out.println(String.format("%-50s", vocabulary.getEn()) +
                        String.format("%-25s", vocabulary.getCns()) + vocabulary.getAbbreviation());
            }
            System.out.println("---------------------------------------下一页------------------------------------");
        }
    }

    /**
     * 得到每个Vocabulary对象
     *
     * @param src
     * @return
     */
    public static Vocabulary getVocabulary(String src) {
        Vocabulary vocabulary = null;
        if (src != null && src.length() > 0) {
            String[] v = src.split("[#]");
            //获取英文
            String wordEn = v[0];
            //获取中文
            String[] wordCh = v[1].split(":");
            //转换为集合
            ArrayList<String> chinese = CollectionUtil.toList(wordCh);
            //获得缩写
            if (v.length > 2) {
                vocabulary = new Vocabulary(wordEn, chinese, v[2]);
            } else {
                vocabulary = new Vocabulary(wordEn, chinese);
            }

        }
        return vocabulary;
    }
}