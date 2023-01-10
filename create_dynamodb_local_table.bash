aws dynamodb create-table --table-name Tool --key-schema AttributeName=Id,KeyType=HASH --attribute-definitions AttributeName=Id,AttributeType=S --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://localhost:8000;

aws dynamodb list-tables --endpoint-url http://localhost:8000