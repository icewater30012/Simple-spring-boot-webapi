FROM websphere-liberty:kernel

# Add my app and config
COPY --chown=1001:0  target/ibm-demo-api.war /config/dropins/
COPY --chown=1001:0  server.xml /config/

# Default setting for the verbose option
ARG VERBOSE=false

# This script will add the requested XML snippets, grow image to be fit-for-purpose and apply interim fixes
RUN configure.sh