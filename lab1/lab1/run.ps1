# Compile and run ProductMgmtApp
$outDir = Join-Path $PSScriptRoot 'out'
if (-not (Test-Path $outDir)) { New-Item -ItemType Directory -Path $outDir | Out-Null }

# Using 'edu' as the project source root
$srcRoot = Join-Path $PSScriptRoot 'edu'

$productFile = Join-Path $srcRoot 'miu/cs/cs489appsd/lab1/productmgmtapp/model/Product.java'
$appFile = Join-Path $srcRoot 'miu/cs/cs489appsd/lab1/productmgmtapp/ProductMgmtApp.java'

Write-Host "Compiling... (source root: $srcRoot)"
& javac -d $outDir $productFile $appFile
if ($LASTEXITCODE -ne 0) { Write-Error "Compilation failed"; exit $LASTEXITCODE }

Write-Host "Running..."
& java -cp $outDir edu.miu.cs.cs489appsd.lab1.productmgmtapp.ProductMgmtApp
