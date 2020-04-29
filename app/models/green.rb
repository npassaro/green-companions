class Green < ApplicationRecord
  validates :name, uniqueness: true

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
