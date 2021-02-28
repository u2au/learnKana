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
#include <algorithm>
// #include <iterator> // begin(), end()

using namespace std;

int main(int argc, const char * argv[]) {
    // Initialization
    int question = 1;
    int correctAnswers = 0;
    int mistakes = 0;
    //    string mistakesArray [] = {};
    //    string unskilled[] = {};
    
    // Dictionary
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
    
    // Welcome
    cout << "Welcome! This is a software that allows you to review hiragana." << endl;
    sleep(3);
    cout << "If you haven't finished learning it yet, you may encounter some hiragana that you don't know during the use of this software." << endl;
    sleep(3);
    cout << "By the way, you can end the review and generate a learning report by entering 'stop'." << endl;
    sleep(3);
    
    // Beginning
    string input = "1";
    cout << "Which part do you want to practice?" << endl;
    cout << "1 > Hiragana" << endl;
    cout << "2 > Katakana" << endl;
    cin >> input;
    if (input == "1") {
        cout << "Do you want the hiragana WITH or WITHOUT the additional sounds included? Such as ば, ぴ." << endl;
        cout << "1 > Yes (WITH)" << endl;
        cout << "2 > No (WITHOUT)" << endl;
        cin >> input;
        //        }
        
        system("clear");
        
        // Full Version of Hiragana
        if (input == "1") {
            for (;input != "stop";) {
                int number = rand() % (46 + 25);
                auto questionString = to_string(question);
                auto correctAnswersString = to_string(correctAnswers);
                
                // Debug Mode
                //                cout << "\n<<< Debug Mode >>>" << endl;
                //                cout << "Question Number: " + questionString << endl;
                //                cout << "Correct Answers: " + correctAnswersString + "\n" << endl;
                //                cout << question << endl;
                //                cout << correctAnswers << endl;
                //                cout << mistakesArray[0] << endl;
                // Debug Mode End
                
                // Question
                string tempHiragana = hiragana[number];
                cout << "Question " + questionString + ": " << endl;
                cout << "How should " + tempHiragana + " be pronounced?" << endl;
                question++;
                cin >> input;
                //                vector<string> mistakesArray;
                //                vector<string> unskilled;
                if (input == hiraganaAnswer[number]) {
                    cout << "Congratulations! Your answer is correct!\n" << endl;
                    correctAnswers++;
                    
                    // Wrong Answer
                } else {
                    cout << "Keep practicing! The pronunciation of " + tempHiragana + " is " + hiraganaAnswer[number] + "!\n" << endl;
                    mistakes++;
                    // Categorising Mistakes (1/2+)
                    //                    if (binary_search(mistakesArray.begin(), mistakesArray.end(), tempHiragana)) {
                    //                        mistakesArray.push_back(tempHiragana);
                    //                    } else {
                    //                        unskilled.push_back(tempHiragana);
                    //                    }
                    //                    // Debug Mode
                    //                    cout << tempHiragana << endl;
                    //                    cout << mistakesArray[0] << endl;
                }
                // Question End
            }
            
        }
        // Easy Version of Hiragana
        else if (input == "2") {
            for (;input != "stop";) {
                int number = rand() % (46);
                auto questionString = to_string(question);
                auto correctAnswersString = to_string(correctAnswers);
                
                // Debug Mode
                //                cout << "\n<<< Debug Mode >>>" << endl;
                //                cout << "Question Number: " + questionString << endl;
                //                cout << "Correct Answers: " + correctAnswersString + "\n" << endl;
                //                cout << question << endl;
                //                cout << correctAnswers << endl;
                //                cout << mistakesArray[0] << endl;
                // Debug Mode End
                
                // Question
                string tempHiragana = hiragana[number];
                cout << "Question " + questionString + ": " << endl;
                cout << "How should " + tempHiragana + " be pronounced?" << endl;
                question++;
                cin >> input;
                if (input == hiraganaAnswer[number]) {
                    cout << "Congratulations! Your answer is correct!\n" << endl;
                    correctAnswers++;
                    
                    // Wrong Answer
                } else {
                    cout << "Keep practicing! The pronunciation of " + hiragana[number] + " is " + hiraganaAnswer[number] + "!\n" << endl;
                    mistakes++;
                    //                    vector<string> mistakesArray;
                    //                    vector<string> unskilled;
                    //                    // Categorising Mistakes (1/2+)
                    //                    if (find(begin(mistakesArray), end(mistakesArray), tempHiragana) != mistakesArray.end()) {
                    //                        mistakesArray.push_back(tempHiragana);
                    //                    } else {
                    //                        unskilled.push_back(tempHiragana);
                    //                    }
                    //                    // Debug Mode
                    //                    cout << mistakesArray[0] << endl;
                    //                    cout << mistakesArray[1] << endl;
                    //                }
                    // Question End
                }
            }
            // Easy Version of Hiragana End
            
            //    // Debug Mode
            //    cout << mistakesArray[0] << endl;
            //    cout << "Do you need to see the hiragana that was answered incorrectly? (y/n)" << endl;
            //    cin >> input;
            //    if (input == "y") {
            //        cout << "Here are the hiragana that were answered incorrectly more than once:" << endl;
            //        vector<string> unskilled;
            //        for (int i = 0; i < unskilled.size(); i++) {
            //            cout << unskilled[i] << endl;
            //
            //        }
            //        cout << "\nMore than twice:" << endl;
            //        vector<string> mistakesArray;
            //        for (int j = 0; j < mistakesArray.size(); j++) {
            //            cout << mistakesArray[j] << endl;
            //
            //        }
            //
        }
        // Over
        auto questionString = to_string(question - 2);
        auto correctAnswersString = to_string(correctAnswers);
        cout << "Thank you for your hard work! You answered a total of " + questionString + " questions, of which " + correctAnswersString + " were correct." << endl;
        cout << "\nIf you have a good idea, please contact me at Discord: Rinsuki#8715." << endl;
        return 0;
    }
}
