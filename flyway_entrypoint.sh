echo "-----------Fetching mounted secrets-----------"
secrets=$(ls /tropos-secrets)
for f in $secrets; do
  export "$f"=$(cat /tropos-secrets/${f})
done
flyway -configFiles=config.conf migrate