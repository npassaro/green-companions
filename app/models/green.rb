class Green < ApplicationRecord
  validates :name, uniqueness: true
end
