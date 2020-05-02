class Green < ApplicationRecord
  has_many :green_companionships, as: :companion, inverse_of: :green, class_name: 'Companionship'
  has_many :bad_companions, through: :green_companionships, source: :companion, source_type: 'BadCompanion'
  has_many :good_companions, through: :green_companionships, source: :companion, source_type: 'GoodCompanion'

  validates :name, presence: true, uniqueness: true

  after_initialize :initialize_with_empty_range

  private

  def initialize_with_empty_range
    self.sow_period = initialize_period_with_empty_range(self.sow_period)
    self.grow_period = initialize_period_with_empty_range(self.grow_period)
    self.harvest_period = initialize_period_with_empty_range(self.harvest_period)
  end

  def initialize_period_with_empty_range(period)
    if period.nil?
      Range.new(0, 0)
    end
    period
  end
end

class BadCompanion < Green
  has_many :bad_companionships, as: :companion, inverse_of: :companion, class_name: 'Companionship'
  has_many :greens, through: :bad_companionships
end

class GoodCompanion < Green
  has_many :good_companionships, as: :companion, inverse_of: :companion, class_name: 'Companionship'
  has_many :greens, through: :good_companionships
end
