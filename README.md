## Sales Taxes
This program takes txt files as input and prints out a receipt with sales tax calculated. Basic sales tax at a rate of 10% on all goods, except books, food, and medical products, is applied to each item and an additional 5% is applied on all imported goods with no exemptions.

## Input Format
Create a txt file and list the contents of your shopping basket in the following format: \[quantity\] (imported) \[item\] at \[price\].

Examples:
- 1 book at 12.49
- 2 imported bottle of perfume at 47.50
- 3 chocolate bars at 0.85

Each item should be listed on its own line.

## How to Use
First, compile the program.

```bash
javac salesTaxes.java
```

Then after it has compiled, create your input files in the same folder. From there, you run the program with the file names as inputs. For example, for the files Input1.txt, Input2.txt, and Input2.txt, we run the following command:

```bash
java salesTaxes Input1.txt Input2.txt Input3.txt
```
