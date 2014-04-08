#!/bin/sh

data_dir=/Users/ellie/Documents/Class/526/CIS526/term-project/data/es

java -mx4g -DJACANA_HOME=../ -jar ../build/lib/jacana-align.jar -m $1 -a $data_dir/test/test.txt -o test.es-en.json
python get_aligns.py test.es-en.json > default.a

python ../../grade -g default.a -r ../../../data/es/test/test.a 

