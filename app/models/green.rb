class Green < ApplicationRecord

  include Validators

  has_many :companionships, inverse_of: :green
  has_many :bad_companions, through: :companionships, source: :companion, source_type: 'BadCompanion'
  has_many :good_companions, through: :companionships, source: :companion, source_type: 'GoodCompanion'

  validates :name, presence: true, uniqueness: true
  validates :sow_period, months_array: true
  validates :grow_period, months_array: true
  validates :harvest_period, months_array: true

  after_initialize :initialize_with_empty_array

  private
    def initialize_with_empty_array
      self.sow_period = [] if self.sow_period.nil?
      self.grow_period = [] if self.grow_period.nil?
      self.harvest_period = [] if self.harvest_period.nil?
    end
end
