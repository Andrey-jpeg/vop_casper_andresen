# Tasks

## Recursion
Package `vop` contains `FindFilesRecursive.java`. It shall take a directory on your computer as input, recursively search all files in the directory and its sub-directories:
- Implement the method `findFiles(File file)` so if the file is atomic, increase noFiles and write the full
path to the file on `System.out`. If it is a directory, increase noDirs and make a recursivecall.
### Some training in controlling index’s in arrays: (From exam 2009)
##### Manipulation af arrays 25%
Der skal implementeres en klasse med to metoder, der som input tager et array med tilfældige positive heltal
   mellem 0 og 100.
- Tallene skal ordnes så alle ulige tal står før alle lige tal. Fx:
  
   `Input: [71, 1, 2, 68, 36, 59, 70, 22, 81, 89]`
  
   `Output: [71, 1, 59, 81, 89, 22, 70, 36, 68, 2]`
   Metodens signatur skal være:
   `public int[] evenOdd(int [] array);`
   
    _Hint: Der må gerne arbejdes med et temp-array, hvor ulige tal kopieres ind forfra og lige tal bagfra._
- De to dele af arrayet skal nu sorteres så de ulige tal står i stigende orden og de lige i faldende. Fx:
  
   `Input: [71, 1, 2, 68, 36, 59, 70, 22, 81, 89]`
  
   `EvenOdd: [71, 1, 59, 81, 89, 22, 70, 36, 68, 2]`
   
    `Output: [1, 59, 71, 81, 89, 70, 68, 36, 22, 2]`
  
   Metoden skal kaldes indefra `evenOdd()` før denne returnerer og have signaturen:
   
    `private void sort(int [] array, int splitIndex);`
   
    hvor splitIndex er placeringen af det første lige tal i arrayet. I eksemplet herover er splitIndex = 5.