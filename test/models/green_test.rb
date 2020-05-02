require 'test_helper'

class GreensTest < ActiveSupport::TestCase
  test "fixtures are saved" do
    assert_equal greens.count, Green.count
  end

  test "name is unique" do
    green = Green.new greens(:green_one).dup.serializable_hash
    assert_not green.valid?
  end
end
