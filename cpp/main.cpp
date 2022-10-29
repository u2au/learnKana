//
//  main.cpp
//  Hiragana
//
//  Created by Rinsuki on 2021/2/27.
//

#include <iostream>
#include <ctime>
#include <unistd.h>
#include <vector>
#include <stdlib.h>
using namespace std;

int main(int argc, const char * argv[]) {
    // 初始化
    int question = 1;
    int correctAnswer = 0;
    int wrongAnswer = 0;
    vector <string> once;
    vector <string> more;
    vector <string> onceAnswer;
    vector <string> moreAnswer;
    
    // 字典
    string hiragana[] = {
        // a
        "あ", "い", "う", "え", "お",
        // ka
        "か", "き", "く", "け", "こ",
        // sa
        "さ", "し", "す", "せ", "そ",
        // ta
        "た", "ち", "つ", "て", "と",
        // na
        "な", "に", "ぬ", "ね", "の",
        // ha
        "は", "ひ", "ふ", "へ", "ほ",
        // ma
        "ま", "み", "む", "め", "も",
        // ra
        "ら", "り", "る", "れ", "ろ",
        // ya
        "や", "ゆ", "よ",
        // wa
        "わ", "を",
        // n
        "ん",
        // ga
        "が", "ぎ", "ぐ", "げ", "ご",
        // za
        "ざ", "じ", "ず", "ぜ", "ぞ",
        // da
        "だ", "ぢ", "づ", "で", "ど",
        // ba
        "ば", "び", "ぶ", "べ", "ぼ",
        // pa
        "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"
    };
    
    string hiraganaAnswer[] = {
        // a
        "a", "i", "u", "e", "o",
        // ka
        "ka", "ki", "ku", "ke", "ko",
        // sa
        "sa", "shi", "su", "se", "so",
        // ta
        "ta", "chi", "tsu", "te", "to",
        // na
        "na", "ni", "nu", "ne", "no",
        // ha
        "ha", "hi", "fu", "he", "ho",
        // ma
        "ma", "mi", "mu", "me", "mo",
        // ra
        "ra", "ri", "ru", "re", "ro",
        // ya
        "ya", "yu", "yo",
        // wa
        "wa", "wo",
        // n
        "n",
        // ga
        "ga", "gi", "gu", "ge", "go",
        // za
        "za", "ji", "zu", "ze", "zo",
        // da
        "da", "di", "du", "de", "do",
        // ba
        "ba", "bi", "bu", "be", "bo",
        // pa
        "pa", "pi", "pu", "pe", "po"
    };
    
    system("clear");
    
    // 欢迎
    cout << "欢迎！这是一个可以让你复习平假名（Hiragana）的软件！" << endl;
    sleep(3);
    cout << "如果你还没有学完平假名，你可能在复习过程中遇到一些不认识的平假名." << endl;
    sleep(3);
    cout << "如果您想结束学习并生成错题报告，请输入 'stop'." << endl;
    sleep(3);
    
    // 开始
    string input = "1";
//    cout << "你想复习 Hiragana 还是 Katakana 呢？" << endl;
//    cout << "1 > Hiragana" << endl;
//    cout << "2 > Katakana" << endl;
//    cin >> input;
//    if (input == "1") {
        cout << "你需要针对浊音以及半浊音的考察吗？例如：ば, ぴ." << endl;
        cout << "1 > Yes (WITH)" << endl;
        cout << "2 > No (WITHOUT)" << endl;
        cin >> input;
//        }
    
    system("clear");
    
    // 带浊音以及半浊音的 Hiragana
        if (input == "1") {
            for (;input != "stop";) {
                int number = rand() % (46 + 25);
                auto questionString = to_string(question);
                auto correctAnswertring = to_string(correctAnswer);
                
                // 提问
                cout << "Question " + questionString + ": " << endl;
                cout << hiragana[number] << " 应该怎么念？" << endl;
                question++;
                cin >> input;
                if (input == hiraganaAnswer[number]) {
                    cout << "回答正确！\n" << endl;
                    correctAnswer++;
                    
                } else if (input == "stop") {
                    break;
                    
                } else {
                    cout << "加油！" + hiragana[number] + " 的正确答案是 " + hiraganaAnswer[number] + "!\n" << endl;
                    wrongAnswer++;
                    // 错题记录
                    if (find(once.begin(), once.end(), hiragana[number]) == once.end()) {
                        once.push_back(hiragana[number]);
                        onceAnswer.push_back(hiraganaAnswer[number]);
                    } else {
                        more.push_back(hiragana[number]);
                        moreAnswer.push_back(hiraganaAnswer[number]);
                    }
                }
                // 问题结束
            }
            
        }
        // 不带浊音以及半浊音的 Hiragana
        else if (input == "2") {
            for (;;) {
                int number = rand() % (46);
                auto questionString = to_string(question);
                auto correctAnswertring = to_string(correctAnswer);
                
                // 提问
                cout << "Question " + questionString + ": " << endl;
                cout << hiragana[number] << " 应该怎么念？" << endl;
                question++;
                cin >> input;
                if (input == hiraganaAnswer[number]) {
                    cout << "回答正确！\n" << endl;
                    correctAnswer++;
                    
                } else if (input == "stop") {
                    break;
                    
                } else {
                    cout << "加油！" + hiragana[number] + " 的正确答案是 " + hiraganaAnswer[number] + "!\n" << endl;
                    wrongAnswer++;
                    // 错题记录
                    if (find(once.begin(), once.end(), hiragana[number]) == once.end()) {
                        once.push_back(hiragana[number]);
                        onceAnswer.push_back(hiraganaAnswer[number]);
                    } else {
                        more.push_back(hiragana[number]);
                        moreAnswer.push_back(hiraganaAnswer[number]);
                    }
                }
            }
        }
            
        // Over
        auto questionString = to_string(question - 2);
        auto correctAnswertring = to_string(correctAnswer);
        cout << "辛苦啦！你已经回答了 " + questionString + " 个问题，其中正确的有 " + correctAnswertring + " 个." << endl;
        cout << "你想要看错题吗？（y/n）" << endl;
        cin >> input;
        if (input == "y" || input == "Y") {
            // 检查 more 是否为空集
            if (more.size() > 0) {
                cout << "错过两次及以上的平假名或片假名：" << endl;
                for (int i = 0; i < more.size(); i++) {
                    cout << more[i] << "(" << moreAnswer[i] << ") " << endl;
                }
            }
            // 错过一次的平假名或片假名
            if (once.size() > 0) {
                cout << "\n错过一次的平假名或片假名：" << endl;
                for (int j = 0; j < once.size(); j++) {
                cout << once[j] << "(" << onceAnswer[j] << ") " << endl;
                }
            }
            // 如果没有错题并且答题数不为 0 的话
            if (more.size() == 0 && once.size() == 0 && question > 0 && wrongAnswer == 0) {
                cout << "厉害了！你回答了 " << questionString << " 道题，而且完全没有错误！" << endl;
            } else if (wrongAnswer/question >= 0.5) {
                cout << "还需要多多练习哦！加油！" << endl;
            }
        }
        cout << "如果你有任何好的想法，欢迎交流！QQ：1090356836." << endl;
        return 0;
        }
//}
