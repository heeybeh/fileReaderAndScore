# File reader And Score is a command line driven text search engine.

This read all the text files in the given directory, building an in-memory representation of the files and their contents, and then give a command prompt at which interactive searches can be performed.

File reader has 4 main features:
- Directory reader
- File reader
- Punctuation of searched words
- Sorting of elements by score

### To run it, have at least java 8.

The executable jar is in:

fileReaderAndScore/SearchingTool/src/com/backend/

### RUN IT

```sh
java -jar searcher.jar "/example/dir"
```

### NOTE
if you are using a different version of the java that I used to generate the jarfile, please follow the steps below.

Step 1: delete searcher.jar

Step 2: inside fileReaderAndScore/SearchingTool/src/com/backend/ run

```sh
javac -d . *.java
```
Step 3: run
```sh
jar -cmf manifest.mf searcher2.jar com
```

Step 4: execute jarfile

```sh
java -jar searcher2.jar "/example/dir"
```

