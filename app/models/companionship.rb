class Companionship < ApplicationRecord
  belongs_to :green
  belongs_to :companion, polymorphic: true
end
