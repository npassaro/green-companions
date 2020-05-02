class Companionship < ApplicationRecord
  belongs_to :green
  belongs_to :companion, polymorphic: true
  validates_uniqueness_of :green_id, scope: :companion_id
end
