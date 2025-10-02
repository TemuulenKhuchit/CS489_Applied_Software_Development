# Product Management CLI (Lab 1)

This small Java CLI app prints the provided products data in JSON, XML and CSV formats.

How to run (PowerShell):

1. Compile + run with the helper script:

   .\run.ps1

2. Or compile and run manually:

   javac -d out edu\miu\cs\cs489appsd\lab1\productmgmtapp\model\Product.java edu\miu\cs\cs489appsd\lab1\productmgmtapp\ProductMgmtApp.java
   java -cp out edu\miu\cs\cs489appsd\lab1\productmgmtapp\ProductMgmtApp

The program prints three sections to stdout: JSON, XML and CSV.
