#!/bin/sh
set -e

echo "$@"
# Remove a potentially pre-existing server.pid for Rails.
rm -f /app/tmp/pids/server.pid

echo "$@"
# Then exec the container's main process (what's set as CMD in the Dockerfile).
exec "$@"