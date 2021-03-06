# SjpAPI - Android version
## API to easy get word from www.sjp.pl 

SjpAPI was created to get info ***ONLINE*** of any word from [Słownik języka polskiego site](www.sjp.pl)

For example:
- Check is word in dictionary
- Check if word can be used in game like scrabble
- Print all of meaning of a word
 
## Tables of contents:
1. [ Do i need this API? ](#need)
2. [ How it works? ](#how)
3. [ Features ](#fea)
4. [Used technology](#tech)
5. [ Installation ](#instal)
6. [ Using API ](#using)
7. [ Examples using ](#examples)
8. [ License ](#lic)

<a name="need">.</a>
## Do i need this API?

### When you need this API:
- Get "as fresh as tropical fruit"(***ONLINE***) meaning of any word in dictionary ["słownik języka polskiego"](https://www.sjp.pl) 

### When you dont need this API:
- Only need check word is in dictionary or can be used in game like scrabble.
In this case you can check any link from [there](https://sjp.pl/slownik/po.phtml)
resolve your problem.

<a name="how">.</a>
## How it works
It is very simple. I locate all GET output from searching word is similary. For example:
- Any name of word is in "h1" tag
- Any info about word can be used game like scrabble is under word name.
- Any meaning of word is under "znaczenie:"

So to this dependencies i create schema:
![schema](https://github.com/GHRik/SjpAPI/blob/main/schema/block_schema.PNG?raw=true)

```diff
- According to this dependencies any small changes in sjp.pl site
- might make SjpAPI unusable.
+ I will try to support if needed :D
```

### Examples Http outputs

Http output when i try to reach word: "zamek" https://sjp.pl/zamek
![Zamek_find](https://github.com/GHRik/SjpAPI/blob/main/examplesInCurl/curlZamekExample.PNG?raw=true)
Http output when i try to reach word who is not in dictionary:
![Not_find_in_dictionary](https://github.com/GHRik/SjpAPI/blob/main/examplesInCurl/curlNotDetectedExample.PNG?raw=true)


<a name="fea">.</a>
## Features

- Print word in JSON format
- Use like .jar library

SjpAPI is a library which "check" word online. 
I know all necesarry word can be found [there](https://sjp.pl/slownik/po.phtml),
but **sjp team** working all the time with which word can be used in game like scrabble and
it is not possible to get meaning of any word from site above.
In this case this API was created.

<a name="tech">.</a>
## Tech

Used technology 

- [Android studio](https://developer.android.com/studio) - To develop and test API
- [JUnit](https://junit.org/junit5/) - To test API
- [Java 8](https://java.com/pl/download/help/java8.html) - Languege used in API
- [Słownik Języka Polskiego](https://sjp.pl) - Site which polish dictionary
- [Apache StringUtils](http://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html) - Used in a small string operations ;)  

<a name="instal">.</a>
## Installation

 1. Add [sjpApi.jar](https://github.com/GHRik/SjpAPI/blob/main/library/SjpApi.jar) as extended library to your java project and import:
 ```
 import com.sjp.sjpapi.SjpAPI;
 ```

<a name="using">.</a>
## Using

1. Import
```
import com.sjp.sjpapi.SjpAPI;
```

2. Example of word "owoc":
```
String json = SjpAPI.getWord("owoc");
```

Output from example:
```
{"name":"owoc","count":1,"canBeUsed[0]":true,"variant[0]":"owoc","meaning[0]":"1. występujący u roślin okrytozalążkowych wytwór zalążni słupka kwiatowego;\n2. rezultat działań, wynik, skutek;\n3. potocznie, zbiorowo: płody drzew oraz krzewów owocowych"}
```
##### Means of json field:
- Name: Name of searching word
- Count: How many meaning word have
- canBeUsed[index]: this word as meaning[index] can be used in game like scrabble
- viariant[index]: this field is point from which word searching word is created. For example if you searching for: "równe" , one of the variant is "równa" or "równy" [check it out](https://www.sjp.pl/równe)
- meaning[index]: one of meaning of word


Sometimes a sjp.pl site is in ***bad format*** and it is unavailable to read "meaning" of word. [Look at this issue](https://github.com/GHRik/SjpAPI/issues/6)
So in this case a output from "meaning[index]" field is "BAD FORMAT" , you can see in example below.

For example:
Searching for word "wypasać"
```
String json = SjpAPI.getWord("wypasać");
```
Output from example:
```
{"name":"wypasać","count":1,"canBeUsed[0]":true,"variant[0]":"wypasać","meaning[0]":"BAD FORMAT"}
```

<a name="examples">.</a>
## Examples:
To easy ilustrate i created easy [android app](https://github.com/GHRik/SjpAPI/blob/main/examplesCode/), so you are free to test it:

##### When you input empty string OR is problem with connect to site(no internet connection):
![Empty_string](https://github.com/GHRik/SjpAPI/blob/main/examplesCode/EmptyStringExample.PNG?raw=true)

##### Input: "zamek":
![Zamek_example](https://github.com/GHRik/SjpAPI/blob/main/examplesCode/ZamekExample.PNG?raw=true)

##### Not found in dictionary:
![Not_find_in_dictionary_Example](https://github.com/GHRik/SjpAPI/blob/main/examplesCode/NotFoundInDictionaryExample.PNG?raw=true)


##### BAD FORMATING site:
![Bad_Format](https://github.com/GHRik/SjpAPI/blob/main/examplesCode/BadFormat.PNG?raw=true)


<a name="lic">.</a>
## License
Apache 
