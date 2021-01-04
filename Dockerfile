FROM ruby:2.7.2-alpine3.12
RUN apk add --update --no-cache \
    build-base \
    postgresql-dev \
    postgresql-client \
    nodejs-current \        
    yarn \
    python2 \
    tzdata \
    file


ENV RAILS_ENV production
ENV RAILS_SERVE_STATIC_FILES true
ENV RAILS_LOG_TO_STDOUT true
ENV NODE_ENV production

WORKDIR /app
COPY Gemfile .
COPY Gemfile.lock .
RUN bundle config --global frozen 1 && bundle config set without 'development test'
RUN bundle install -j4 --retry 3 \
    # Remove unneeded files (cached *.gem, *.o, *.c)
    && rm -rf /usr/local/bundle/cache/*.gem \
    && find /usr/local/bundle/gems/ -name "*.c" -delete \
    && find /usr/local/bundle/gems/ -name "*.o" -delete
# Add a script to be executed every time the container starts.
COPY entrypoint.sh /usr/bin/
RUN chmod +x /usr/bin/entrypoint.sh
ENTRYPOINT ["entrypoint.sh"]
EXPOSE 3000
COPY . .
# Start the main process.
CMD ["rails", "server", "-b", "0.0.0.0"]