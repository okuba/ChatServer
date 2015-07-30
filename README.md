# ChatServer

ソフトウェア工学Ⅱの主題2として, 発展プログラミング演習Ⅱの授業の最終課題で作成した「ChatServer」をグループで作成する.

###プログラム概要###
本プロジェクトでは, ビルドツールとして, 'gradle'を用いている.
gradleを使用してのコンパイル方法は, 'gradle build.gradle'となる.

gradleが導入されていない場合は, 'javac'にてChatServer.javaをコンパイルし, 実行すれば良い.

ChatServerにおいて, クライアント側は'telnet localhost 18080' に接続する.  
クライアントは特定のコマンドを用いて, 様々な処理を実行できる. 
  
・HELP … コマンドの説明を表示.
・NAME … 名前の変更を行う(他のユーザと同名は付けることはできない). 
・WHOAMI … クライアント自身の名前を表示.
・BYE … チャットを終了する.
・POST … 全員にメッセージを送信.
・USERS … 自分を含めて, 接続中のユーザ名を一覧で表示.

###実行環境###
・gradleのバージョン
Groovy:       2.3.10
Ant:          Apache Ant(TM) version 1.9.4 compiled on April 29 2014
JVM:          1.8.0_45 (Oracle Corporation 25.45-b02)
OS:           Mac OS X 10.10.4 x86_64

・javaのバージョン
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)

### ・チケット(Issues)の役割分担 ###

ここで, リーダをm0(okuba)とし, メンバとしてm1(yhama)とする.

|            | チケット発行 | チケット担当  | レビュー　| マージ  |
|------------|------------|-------------|---------|--------|
| チケット１   |  m0     |  m1    | m0   | m0　 |
| チケット２   |  m0   |  m0      | m1　 | m1 |
| チケット３   |  m0    |  m0　    | m1 | m1   |  
| チケット４   |  m0    |  m1    |m0  | m0　 |
| チケット５   |  m0   |  m1      | m0　 | m0|
| チケット６   |  m0     |  m1　    | m0 | m0  | 
| チケット７   |  m0     |  m1    | m0  | m0　 |
| チケット８   |  m0  |  m1      | m0　 | m0|
| チケット９   |  m0     |  m0　    | m1 | m1   | 
| チケット10   |  m0    |  m0　    | m1 | m1   | 
| チケット11  |  m0     |  m0　    | m1 | m1  | 
| チケット12   |  m0     |  m1　    |m0 | m0   | 
| チケット13  |  m0     |  m0　    | m1 | m1   | 
| チケット14  |  m0     |  m1　    | m0 | m0   | 
| チケット15  |  m0     |  m0　    | m1 | m1   | 
| チケット16  |  m0     |  m1　    | m0 | m0   | 