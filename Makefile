.PHONY: run_database run_s3ninja

run_database:
	docker-compose up -d

run_s3jinja:
	cd ./src/main/resources/s3ninja && java8 IPL
