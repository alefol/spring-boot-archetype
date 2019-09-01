# Derived from official postgres image (our base image)
FROM postgres
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./scripts/* /docker-entrypoint-initdb.d/